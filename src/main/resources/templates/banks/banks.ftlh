<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Banks</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
  <H3><a href="/">Banks</a></H3>
  <br>
  <a href="/banks/new"> New bank </a>
  <br>
    <#if banks?? && (banks?size > 0)>
    <table id="banks" border=1>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Edit</th>
          <th>Delete</th>
        </tr>
    <#list banks as bank>
    <tr>
      <td>
         <span> ${bank.uuid} </span>
      </td>
      <td>
         <a href="/banks/${bank.uuid}">${bank.name}</a>
      </td>
      <td>
         <a href="/banks/${bank.uuid}/edit">Edit</a>
      </td>
      <td>
         <a href="/banks/${bank.uuid}/delete">Delete</a>
      </td>
    </tr>
    </#list>
    </table>
    <#else>
        No Details Available
    </#if>
  </body>
</html>
