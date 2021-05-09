<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Loans</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
  <H3>Loans</H3>
  <br>
  <a href="/loans/new"> New loan </a>
  <br>
    <#if loans?? && (loans?size > 0)>
    <table id="loans" border=1>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Limit</th>
          <th>Interest</th>
          <th>Edit</th>
          <th>Delete</th>
        </tr>
    <#list loans as loan>
    <tr>
      <td>
         <span> ${loan.uuid} </span>
      </td>
      <td>
         <span> ${loan.name} </span>
      </td>
      <td>
          <span> ${loan.limit} </span>
      </td>
      <td>
         <span> ${loan.interestRate}% </span>
      </td>
      <td>
         <a href="${loan.uuid}/edit">Edit</a>
      </td>
      <td>
         <a href="${loan.uuid}/delete">Delete</a>
      </td>
    </tr>
    </#list>
    </table>
    <#else>
        No Details Available
    </#if>
  </body>
</html>
