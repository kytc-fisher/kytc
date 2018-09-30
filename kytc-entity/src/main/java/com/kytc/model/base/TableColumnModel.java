package com.kytc.model.base;

/**
 * @author 何志同
 * @description table表column列信息
 * @date 2017年6月7日下午10:01:53
 */
public class TableColumnModel {
	private String column_name;
	private String column_default;
	private String is_nullable;
	private String character_set_name;
	private String column_key;
	private String column_type;
	private String extra;
	private String column_comment;
	private String privileges;
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public String getColumn_default() {
		return column_default;
	}
	public void setColumn_default(String column_default) {
		this.column_default = column_default;
	}
	public String getIs_nullable() {
		return is_nullable;
	}
	public void setIs_nullable(String is_nullable) {
		this.is_nullable = is_nullable;
	}
	public String getCharacter_set_name() {
		return character_set_name;
	}
	public void setCharacter_set_name(String character_set_name) {
		this.character_set_name = character_set_name;
	}
	public String getColumn_key() {
		return column_key;
	}
	public void setColumn_key(String column_key) {
		this.column_key = column_key;
	}
	public String getColumn_type() {
		return column_type;
	}
	public void setColumn_type(String column_type) {
		this.column_type = column_type;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getColumn_comment() {
		return column_comment;
	}
	public void setColumn_comment(String column_comment) {
		this.column_comment = column_comment;
	}
	public String getPrivileges() {
		return privileges;
	}
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}
	@Override
	public String toString() {
		return "TableColumnModel [column_name=" + column_name
				+ ", column_default=" + column_default + ", is_nullable="
				+ is_nullable + ", character_set_name=" + character_set_name
				+ ", column_key=" + column_key + ", column_type=" + column_type
				+ ", extra=" + extra + ", column_comment=" + column_comment
				+ ", privileges=" + privileges + "]";
	}
}
