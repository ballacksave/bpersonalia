package org.bareng.hr.web.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.data.domain.Page;
import org.springframework.util.Assert;

/**
 * This tag is highly related to spring data {@link Page} and bootstrap
 * 
 * @author zakyalvan
 */
public class SpringDataPagingTag extends SimpleTagSupport {
	/**
	 * Name of model attribute containing page object. Default to "pagedList"
	 */
	private String pagedListModelName = "pagedList";
	
	/**
	 * Maximum number of navigation link to be displayed.
	 */
	private Short maxNavagationDisplayed = 9;
	
	/**
	 * Request parameter name for page number parameter.
	 */
	private String pageRequestParamName = "page";
	
	/**
	 * Request parameter name for page size parameter.
	 */
	private String sizeRequestParamName = "size";
	
	public void setPagedListModelName(String pagedListModelName) {
		this.pagedListModelName = pagedListModelName;
	}
	public void setMaxNavagationDisplayed(Short maxNavagationDisplayed) {
		Assert.notNull(maxNavagationDisplayed);
		Assert.isTrue(maxNavagationDisplayed > 0);
		
		this.maxNavagationDisplayed = maxNavagationDisplayed;
	}
	public void setPageRequestParamName(String pageRequestParamName) {
		this.pageRequestParamName = pageRequestParamName;
	}
	public void setSizeRequestParamName(String sizeRequestParamName) {
		this.sizeRequestParamName = sizeRequestParamName;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		Page<?> pagedDataList = (Page<?>) getJspContext().getAttribute(pagedListModelName, PageContext.REQUEST_SCOPE);
		Assert.notNull(pagedDataList, String.format("Given name for pagedDataListModelName (%s) is not falid, not found at jsp context", pagedListModelName));
		
		int totalPages = pagedDataList.getTotalPages();
		if(totalPages > 0) {
			Integer numberOfNavigationDisplayed = totalPages > maxNavagationDisplayed ? maxNavagationDisplayed : totalPages;
			
			int currentPage = pagedDataList.getNumber();
			
			int startOfNavigationDisplayed = 0;
			int endOfNavigationDisplayed = numberOfNavigationDisplayed - 1;
			if(totalPages > numberOfNavigationDisplayed) {
				startOfNavigationDisplayed = currentPage - Math.round((numberOfNavigationDisplayed-1)/2);
				endOfNavigationDisplayed = currentPage + Math.round((numberOfNavigationDisplayed)/2);
				
				if(startOfNavigationDisplayed < 0) {
					endOfNavigationDisplayed += ((-1) * startOfNavigationDisplayed);
					startOfNavigationDisplayed = 0;
				}
				else if(endOfNavigationDisplayed > totalPages-1) {
					startOfNavigationDisplayed -= endOfNavigationDisplayed - (totalPages - 1);
					endOfNavigationDisplayed = totalPages-1;
				}
			}
			
			StringBuilder navigationBuilder = new StringBuilder();
			navigationBuilder.append("<ul class=\"pagination\">");
			if(pagedDataList.isFirst() || currentPage > totalPages) {
			    navigationBuilder.append("<li class=\"disabled\"><a aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
			}
			else {
				int prevPage = currentPage - 1;
				navigationBuilder.append(String.format("<li><a href=\"?%s=%d\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>", pageRequestParamName, prevPage));
				
			}
			
			// Loop for number to be displayed navigation.
			for(int i = startOfNavigationDisplayed; i <= endOfNavigationDisplayed; i++) {
				if(i == currentPage) {
					navigationBuilder.append(String.format("<li class=\"active\"><a href=\"?page=%d\">%d</a><li>", i, i+1));
				}
				else {
					navigationBuilder.append(String.format("<li><a href=\"?%s=%d\">%d</a><li>", pageRequestParamName, i, i+1));
				}
			}
			
			if(pagedDataList.isLast() || currentPage > totalPages) {
			    navigationBuilder.append("<li class=\"disabled\"><a aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
			}
			else {
				int nextPage = currentPage + 1;
				navigationBuilder.append(String.format("<li><a href=\"?%s=%d\" aria-label=\"Previous\"><span aria-hidden=\"true\">&raquo;</span></a></li>", pageRequestParamName, nextPage));
			}
			navigationBuilder.append("</ul>");
			
			getJspContext().getOut().write(navigationBuilder.toString());
		}
	}
}