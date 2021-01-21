<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello, I am a Java web app!</title>
    <link href="index.css" rel="stylesheet" type="text/css">

</head>
<%--<div class="loader"></div>--%>
<body>
<p>Result：<%=request.getAttribute("result") %></p>
<p>Path：<%=request.getAttribute("d_file")%> %></p>
<a href="<%=request.getAttribute("d_file")%>" >다운로드!</a>

<h2 id="mld"></h2>

<form id="s_form" method="post" action="HiddenServlet">
<%--<form name="s_form" id="s_form">--%>
    <table>
        <tr>
            <td>입력</td>
            <td><input type="text" id="input" name="in_name"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="송신"></td>
        </tr>
    </table>
    <script>
        var t = document.getElementById('s_form');
        t.addEventListener('submit', function (event) {
            var loadingDIV = document.createElement("div");
            loadingDIV.setAttribute("class", "loader");
            var body = document.getElementById("mld").parentElement;
            body.append(loadingDIV)
            // document.getElementById("s_form").onsubmit;
        })
    </script>
</form>
</body>
</html>
