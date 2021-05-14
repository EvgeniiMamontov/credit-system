<#macro page>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main page</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"></head>
  <body>
    <#include "navbar.ftlh">
    <div class="container mt-5">
        <#nested>
    </div>
  </body>
</html>
</#macro>
