<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Loan Offers</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
  <H3><a href="/">Loan Offers</a></H3>
  <br>
    <#if loanoffers?? && (loanoffers?size > 0)>
    <table id="loanoffers" border=1>
        <tr>
          <th>ID</th>
          <th>Client</th>
          <th>Loan</th>
          <th>Amount</th>
          <th>Loan term</th>
          <th>First payment date</th>
          <th>Edit</th>
          <th>Delete</th>
        </tr>
    <#list loanoffers as loanoffer>
    <tr>
      <td>
         <a href="/loanoffers/${loanoffer.uuid}">${loanoffer.uuid}</a>
      </td>
      <td>
         <span> ${loanoffer.client.fullName} </span>
      </td>
      <td>
          <span> ${loanoffer.loan.name} </span>
      </td>
      <td>
         <span> ${loanoffer.amount} </span>
      </td>
      <td>
         <span> ${loanoffer.loanTerm} </span>
      </td>
      <td>
         <span> ${loanoffer.date} </span>
      </td>
      <td>
         <a href="/loanoffers/${loanoffer.uuid}/edit">Edit</a>
      </td>
      <td>
         <a href="/loanoffers/${loanoffer.uuid}/delete">Delete</a>
      </td>
    </tr>
    </#list>
    </table>
    <#else>
        No Details Available
    </#if>
  </body>
</html>
