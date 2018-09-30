package com.kytc.auth.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HasAnyPremissionTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1403333615105548710L;
	private String premission;
    public String getPremission() {
		return premission;
	}
	public void setPremission(String premission) {
		this.premission = premission;
	}
	public int doStartTag() throws JspException {
    	System.out.println(premission);
    	return EVAL_PAGE;
    }
}
