<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/include/header.jsp" %>

<input type="hidden" id="it_uid" value="${re.it_uid}">
<input type="hidden" id="category2" value="${ca.ca_id}">

<center>
    <table>
        <tr>
            <td><input type="button" value="뒤로가기" onclick="backToThe()"></td>
            <td>리뷰작성</td>
        </tr>
    </table>
    <form method="post" enctype="multipart/form-data">
        <table border="1">
            <tr>
                <td>제목</td>
                <td><input name="rv_sub" required></td>
            </tr>
            <tr>
                <td colspan="2">
                    <textarea rows="15" cols="60" name="rv_text" placeholder="리뷰를 남겨주세요!" id="myTextarea" maxlength="1000" required></textarea>
                </td>
            </tr>
            <tr>
            	<td>
            		<select name="rating">
            			<option value="1">★</option>
            			<option value="2">★★</option>
            			<option value="3">★★★</option>
            			<option value="4">★★★★</option>
            			<option value="5">★★★★★</option>
            		</select>
            	</td>
            </tr>
            <tr>
                <td>첨부파일1</td>
                <td><input type="file" name="file1"></td>
            </tr>
            <tr>
                <td>첨부파일2</td>
                <td><input type="file" name="file2"></td>
            </tr>
            <tr>
                <td>첨부파일3</td>
                <td><input type="file" name="file3"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                	<button>작성 완료</button>
                </td>
            </tr>
        </table>
    </form>
</center>

<%@include file="/include/footer.jsp" %>

<script>
    function backToThe() {
        var it_uid = document.getElementById("it_uid").value;
        var category2 = document.getElementById("category2").value;
        var url = "http://localhost:8080/item/view?it_uid=" + it_uid + "&category2=" + category2;
        location.href = url;
    }
</script>
