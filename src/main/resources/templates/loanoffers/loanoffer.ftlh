<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Loan offer</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
  <H3><a href="/">Loan offer</a></H3>
  <br><br>
    UUID:
  <br>
     ${loanoffer.uuid}
  <br><br>
    Client:
  <br>
    ${loanoffer.client.fullName}
  <br><br>
    Loan:
  <br>
    ${loanoffer.loan.name}
  <br><br>
    Amount:
  <br>
    ${loanoffer.amount}
  <br><br>
    Loan term:
  <br>
    ${loanoffer.loanTerm}
  <br><br>
    Interest:
  <br>
    ${loanoffer.loan.interestRate}%
  <br><br>
    Payment schedule:
  <br>
    <#if loanoffer.paymentSchedule?? && (loanoffer.paymentSchedule?size > 0)>
      <#list loanoffer.paymentSchedule as payment>
        ${payment.date} | ${payment.paymentAmount} | ${payment.principalAmount} | ${payment.interestAmount} <br>
      </#list>
    <#else>
      None
    </#if>
  </body>
</html>
