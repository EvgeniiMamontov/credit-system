<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Bank</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
  <H3><a href="/">Bank</a></H3>
  <br><br>
    UUID:
  <br>
     ${bank.uuid}
  <br><br>
    Name:
  <br>
     ${bank.name}
  <br><br>
    Loans:
  <br>
    <#if bank.loans?? && (bank.loans?size > 0)>
      <#list bank.loans as loan>
        ${loan.name} | ${loan.limit} | ${loan.interestRate}% <br>
      </#list>
    <#else>
      None
    </#if>
  <br><br>
    Clients:
  <br>
    <#if bank.clients?? && (bank.clients?size > 0)>
      <#list bank.clients as client>
        ${client.fullName} | ${loan.phoneNumber} | ${loan.email} | ${loan.passportNumber} <br>
      </#list>
    <#else>
      None
    </#if>
  </body>
</html>
