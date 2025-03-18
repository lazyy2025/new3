package ru.x.core.options;

import lombok.RequiredArgsConstructor;
import ru.x.core.options.enums.Option;

import java.io.Serializable;
import java.util.Map;
import java.util.function.Function;

@RequiredArgsConstructor
public class Options implements Serializable {
    private transient final Map<String, String> options;

    /**
     * Returns value of the required option. Value will be converted to the passed type.
     * If the option doesn't exist in the {@code options} map or value can not be converted to
     * given type, {@link IllegalArgumentException} is thrown.
     *
     * @param option option whose value must be returned.
     * @param clazz  class in which the option value is to be converted.
     * @param <T>    option value type.
     * @return value of the required option.
     */
    protected <T> T getRequired(final Option option,
                                final Class<T> clazz) {
        try {
            return clazz.getConstructor(String.class).newInstance(options.get(option.getName()));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(
                    "Option '%s' is required and must be of the type %s", option.getName(), clazz.getSimpleName()));
        }
    }


    /**
     * Returns the option value if the option exist and otherwise the {@code other} value.
     * If the option value can't be converted to the passed type, {@link IllegalArgumentException} is thrown.
     *
     * @param option option whose value must be returned.
     * @param clazz  class in which the option value is to be converted.
     * @param other  a non-{@code null} object to return if the option doesn't exist.
     * @param <T>    option value type.
     * @return the option value if the option exist and otherwise the {@code other} value.
     */
    protected <T> T getOptional(final Option option,
                                final Class<T> clazz,
                                final T other) {
        final T value = getOptional(option, clazz);
        return value == null ? other : value;
    }

    /**
     * Returns the option value if the option exist and otherwise {@code null}.
     * If the option value can't be converted to the passed type, {@link IllegalArgumentException} is thrown.
     *
     * @param option option whose value must be returned.
     * @param clazz  class in which the option value is to be converted.
     * @param <T>    option value type.
     * @return the option value if the option exist and otherwise {@code null}.
     */
    protected <T> T getOptional(final Option option,
                                final Class<T> clazz) {
        return getOptionalAndMap(option, clazz, Function.identity());
    }


    /**
     * Maps the option value using {@code mapper} if the option exist and otherwise {@code null}.
     * If the option value can't be converted to the passed type, {@link IllegalArgumentException} is thrown.
     *
     * @param option option whose value must be returned.
     * @param clazz  class in which the option value is to be converted.
     * @param mapper a mapper of the option value.
     * @param <T>    option value type.
     * @param <S>    option value type after use {@code mapper}.
     * @return the option value if the option exist and otherwise {@code null}.
     */
    protected <T, S> S getOptionalAndMap(final Option option,
                                         final Class<T> clazz,
                                         final Function<T, S> mapper) {
        final String optionValue = options.get(option.getName());

        if (optionValue == null) {
            return null;
        }

        try {
            return mapper.apply(clazz.getConstructor(String.class).newInstance(optionValue));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(
                    "Option '%s' must be of the type %s", option.getName(), clazz.getSimpleName()));
        }
    }


    /**
     * Returns the option value which must be a positive integer and the option exist, otherwise {@code null}.
     * If the value &lt; 0, {@code IllegalArgumentException} is thrown.
     *
     * @param option option whose value must be returned.
     * @return the option value which must be a positive integer and the option exist, otherwise {@code null}.
     */
    protected Integer getOptionalPositiveInteger(final Option option) {
        final Integer value = getOptional(option, Integer.class);
        if (value != null && value < 0) {
            throw new IllegalArgumentException(
                    String.format("Option '%s' must be the positive integer", option.getName()));
        }
        return value;
    }

    /**
     * Returns the option value which must be a positive long and the option exist,
     * otherwise the {@code other} value. If the value &lt; 0, {@link IllegalArgumentException} is thrown.
     *
     * @param option option whose value must be returned.
     * @param other  non-{@code null} object to return if the option doesn't exist.
     * @return the option value which must be a positive long and the option exist, otherwise the {@code other} value.
     */
    protected Long getOptionalPositiveLong(final Option option,
                                           final Long other) {
        final Long value = getOptional(option, Long.class, other);
        if (value < 0) {
            throw new IllegalArgumentException(
                    String.format("Option '%s' must be the positive long", option.getName()));
        }
        return value;
    }

    /**
     * Returns the option value which must be a string with a length of no more than {@code length} and
     * the option exist. If the length of the option value &gt; {@code length}, {@link IllegalArgumentException} is thrown.
     * If the option doesn't exist return {@code null}.
     *
     * @param option option whose value must be returned.
     * @param length max length of the option value.
     * @return the option value which must be a string with a length of no more than {@code length}
     * and the option exist.
     */
    protected String getOptionalStringWithLength(final Option option,
                                                 final int length) {
        final String value = getOptional(option, String.class);
        if (value != null && value.length() > length) {
            throw new IllegalArgumentException(
                    String.format(
                            "Option '%s' must be a string with a length of no more than %d", option.getName(), length
                    )
            );
        }
        return value;
    }

}
