<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

<header style="z-index: 200">
  <tiles:insertAttribute name="header"></tiles:insertAttribute>
</header>
<main style="z-index: 100">
  <tiles:insertAttribute name="content"></tiles:insertAttribute>
</main>
<footer>
  <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</footer>
</body>
</html>