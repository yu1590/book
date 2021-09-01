<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a#deleteItem").click(function () {

                let b = confirm("你确定要删除【" + $(this).attr("book") + "】吗？");
                return b;
            })

            $("a#clear").click(function () {
                let b = confirm("你确定要清空购物车吗？");
                return b;
            })

            $("input#count").change(function () {
                let b1 = confirm("你确定要将【" + $(this).attr("book") + "】商品的数量修改为【" + $(this).val() + "】吗？");
                if (b1) {
                    location.href = "cartServlet?action=updateCount&id=" + $(this).attr("bookId")+"&count=" + $(this).val();
                } else {
                    $(this).val(this.defaultValue);
                }
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/common/login_success_common.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.cart.items}">
            <tr cl>
                <td colspan="5"><a href="index.jsp">购物车内还没有商品，快去购物吧</a></td>
            </tr>
        </c:if>
        <c:forEach items="${sessionScope.cart.items}" var="item">
            <tr>
                <td>${item.value.name}</td>
                <td><input id="count" style="width: 40px" type="text" value="${item.value.count}"
                           book="${item.value.name}" bookId="${item.value.id}"></td>
                <td>${item.value.price}</td>
                <td>${item.value.totalPrice}</td>
                <td><a href="cartServlet?action=deleteItem&id=${item.value.id}" id="deleteItem"
                       book="${item.value.name}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a href="cartServlet?action=clear" id="clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>