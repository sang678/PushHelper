<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="list">
	<ul>
		<c:forEach var="bean" items="${statisticsList}"	varStatus="status">
			<c:set var="successAverage" value="${bean.send_success/(bean.send_success+bean.send_fail)}" />
			<c:set var="failAverage" value="${bean.send_fail/(bean.send_success+bean.send_fail)}" />
			<li class="data_list data_list_color${status.index % 2}"  >
				<span class="list_title pull-left"
					onClick="showDetail('<c:out value='${bean.group_key}'/>')" >
				<c:out value="${bean.sms_txt}" /></span>
				<c:if test="${bean.st_progress == 0  || bean.st_progress == null}"><img class="pull-right" style="width:71px;height:71px;" src="../resources/img/progressCircle.gif"/></c:if><br>
				<span class="list_time pull-left"><c:out value="${fn:substring(bean.st_time,0,19) }" /></span> <br />
				<span class="list_info pull-left">
					 총합 : <span class="list_sum">${bean.send_success + bean.send_fail }</span> 
					| 성공 : <span class="list_success">
									${bean.send_success }
									( 
										<c:choose>
											<c:when test="${successAverage =='NaN'}">0.0</c:when>
											<c:otherwise>${successAverage*100 }</c:otherwise>
										</c:choose>
									
									% )
							 </span> 
					| 실패 :  <span class="list_fail">${bean.send_fail } 
					
									( 

										<c:choose>
											<c:when test="${failAverage =='NaN'}">0</c:when>
											<c:otherwise>${failAverage*100 }</c:otherwise>
										</c:choose>
									
									% )

							</span>
				</span>
			</li>
		</c:forEach>
		<c:if test="${ fn:length(statisticsList) == 0 }"  >
			<li><h1>발송 내역이 없습니다.</h1></li>
		</c:if>
	</ul>	
</div>