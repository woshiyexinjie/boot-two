package com.helloxin.model.local;

import java.util.ArrayList;
import java.util.Arrays;

public class PpkDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ppk.id
     *
     * @mbg.generated Tue Mar 10 14:49:00 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ppk.msg
     *
     * @mbg.generated Tue Mar 10 14:49:00 CST 2020
     */
    private String msg;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ppk.id
     *
     * @return the value of ppk.id
     *
     * @mbg.generated Tue Mar 10 14:49:00 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ppk.id
     *
     * @param id the value for ppk.id
     *
     * @mbg.generated Tue Mar 10 14:49:00 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ppk.msg
     *
     * @return the value of ppk.msg
     *
     * @mbg.generated Tue Mar 10 14:49:00 CST 2020
     */
    public String getMsg() {
        return msg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ppk.msg
     *
     * @param msg the value for ppk.msg
     *
     * @mbg.generated Tue Mar 10 14:49:00 CST 2020
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ppk
     *
     * @mbg.generated Tue Mar 10 14:49:00 CST 2020
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ppk
     *
     * @mbg.generated Tue Mar 10 14:49:00 CST 2020
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        private PpkDO obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public Builder() {
            this.obj = new PpkDO();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ppk.id
         *
         * @param id the value for ppk.id
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public Builder id(Integer id) {
            obj.setId(id);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ppk.msg
         *
         * @param msg the value for ppk.msg
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public Builder msg(String msg) {
            obj.setMsg(msg);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public PpkDO build() {
            return this.obj;
        }
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table ppk
     *
     * @mbg.generated Tue Mar 10 14:49:00 CST 2020
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        msg("msg", "msg", "VARCHAR", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        private static final String BEGINNING_DELIMITER = "\"";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        private static final String ENDING_DELIMITER = "\"";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public static Column[] all() {
            return Column.values();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ppk
         *
         * @mbg.generated Tue Mar 10 14:49:00 CST 2020
         */
        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}