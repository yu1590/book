<%--
  Created by IntelliJ IDEA.
  User: yuyingjie
  Date: 2021/8/26
  Time: 9:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNO > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNO-1}">上一页</a>
    </c:if>


    <c:choose>

        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
        </c:when>

        <c:otherwise>

            <c:choose>
                <c:when test="${requestScope.page.pageNO <= 3}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>
                </c:when>
                <c:when test="${requestScope.page.pageNO >= requestScope.page.pageTotal - 2}">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNO - 2}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageNO + 2}"></c:set>
                </c:otherwise>
            </c:choose>

        </c:otherwise>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${requestScope.page.pageNO != i}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
        <c:if test="${requestScope.page.pageNO == i}">
            <a>[${i}]</a>
        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageNO < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNO+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${requestScope.page.pageNO}" name="pn" id="pn_input"/>页
    <input type="button" id="btn" value="确定">
</div>

<script type="text/javascript">
    $("#btn").click(function () {
        let val = $("#pn_input").val();
        location.href =  "${requestScope.path}${requestScope.page.url}&pageNo=" + val;
    })
</script>