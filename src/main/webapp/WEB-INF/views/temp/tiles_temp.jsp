<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css" />
  <link rel="stylesheet" href="/css/common.css" />
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Philosopher&display=swap"  rel="stylesheet"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

</head>
<body>
<header>
  <tiles:insertAttribute name="header"></tiles:insertAttribute>
</header>
<main>
  <tiles:insertAttribute name="content"></tiles:insertAttribute>
</main>
<footer>
  <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</footer>
</body>
</html>