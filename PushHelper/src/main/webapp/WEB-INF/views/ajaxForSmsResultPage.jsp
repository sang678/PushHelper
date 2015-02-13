<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="list">
	<ul>
		<c:forEach var="bean" items="${detailList}"	varStatus="status">
			<c:set var="result" value="${bean.rslt_code2}" />
			<li class="data_list data_list_color${status.index % 2}" />
				<span class="list_call_result">
					<span class="list_call_to">${bean.call_to}</span> | 
					<span class="list_result">
						${bean.msg_etc1}
					</span>
				</span>
				<span class="list_info">
					 | 실제발송시간 | <span class="list_sentdate">${fn:substring(bean.sent_date,0,19)}</span><br />
					 | 결과도착시간 | <span class="list_rsltdate">${fn:substring(bean.rslt_date,0,19)}</span>
				</span>
			</li>
		</c:forEach>
	</ul>	
</div>