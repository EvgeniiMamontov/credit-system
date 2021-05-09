<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Clients</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
  <H3><a href="/">Clients</a></H3>
  <br>
  <a href="/clients/new"> New client </a>
  <br>
    <#if clients?? && (clients?size > 0)>
    <table id="clients" border=1>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Phone number</th>
          <th>Email</th>
          <th>Passport number</th>
          <th>Edit</th>
          <th>Delete</th>
        </tr>
    <#list clients as client>
    <tr>
      <td>
         <span> ${client.uuid} </span>
      </td>
      <td>
         <span> ${client.fullName} </span>
      </td>
      <td>
          <span> ${client.phoneNumber} </span>
      </td>
      <td>
         <span> ${client.email} </span>
      </td>
      <td>
         <span> ${client.passportNumber} </span>
      </td>
      <td>
         <a href="/clients/${client.uuid}/edit">Edit</a>
      </td>
      <td>
         <a href="/clients/${client.uuid}/delete">Delete</a>
      </td>
    </tr>
    </#list>
    </table>
    <#else>
        No Details Available
    </#if>
  </body>
</html>
