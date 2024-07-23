<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "/include/header.jsp"%>

<center>
<br>
    <table width="600">
        <tr>
            <td colspan="2" align="center" height="40" bgcolor="black" style="color:white;font-size:18px;font-weight:bold;">
            ${re.rv_sub }</td>
        </tr>
        <tr>
            <c:choose>
            	<c:when test="${not empty re.file1 && not empty re.file2 && not empty re.file3}">
	            	<table>
	            		<tr>
	            			<td rowspan="2">
	            				<img src="/upload_item/${re.file1 }" style="width:400px;height:400px;">
	            			</td>
	            			<td>
	            				<img src="/upload_item/${re.file2 }" style="width:195px;height:195px;">
	            			</td>
	            		</tr>
	            		<tr>
	            			<td>
	            				<img src="/upload_item/${re.file3 }" style="width:195px;height:195px;">
	            			</td>
	            		</tr>
	            	</table>
            	</c:when>
            	<c:when test="${(not empty re.file1 && not empty re.file2) || (not empty re.file1 && not empty re.file3) || (not empty re.file2 && not empty re.file3)}">
	            	<table>
	            		<tr>
	            			<td>
	            				<img src="/upload_item/${re.file1 }" style="width:298px;height:298px;">
	            			</td>
	            			<td>
	            				<img src="/upload_item/${re.file2 }" style="width:298px;height:298px;">
	            			</td>
	            		</tr>
	            	</table>
            	</c:when>
            	<c:when test="${empty re.file1 && empty re.file2 && empty re.file3}">
            		<td colspan="2" height="1"></td>
            	</c:when>
				<c:otherwise>
            		<c:choose>
					    <c:when test="${not empty re.file1 && empty re.file2 && empty re.file3}">
	            			<td align="center" colspan="2">
	            				<img src="/upload_item/${re.file1 }" style="width:300px;height:300px;">
	            			</td>
					    </c:when>
					    <c:when test="${empty re.file1 && not empty re.file2 && empty re.file3}">
	            			<td align="center" colspan="2">
	            				<img src="/upload_item/${re.file2 }" style="width:300px;height:300px;">
	            			</td>
					    </c:when>
					    <c:when test="${empty re.file1 && empty re.file2 && not empty re.file3}">
	            			<td align="center" colspan="2">
	            				<img src="/upload_item/${re.file3 }" style="width:300px;height:300px;">
	            			</td>
					    </c:when>
					</c:choose>
            	</c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <td colspan="2" align="center">
            <textarea rows="5" cols="72"  style="border:none;text-align:center;font-size:16px;"
             readonly>${re.rv_text }</textarea>
            </td>
        </tr>
    </table>
	<br>
    <table width="600">
        <tr>
        	<td></td>
            <td width="100" height="40">
            <input type="button" value="뒤로가기" style="width:100px;height:40px;background-color:black;color:white;"
             onclick="history.back()"></td>
        </tr>
    </table>
    <br>
</center>

<%@include file = "/include/footer.jsp"%>