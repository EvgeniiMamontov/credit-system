<#import "/main.ftlh" as main>
<@main.page>
    <form action="/loanoffers/new">
      <button class="btn btn-primary" type="submit">New loan offer</button>
    </form>
    <table class="table container mt-5">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Loan offer</th>
          <th scope="col">Client</th>
          <th scope="col">Loan name</th>
          <th scope="col">Amount</th>
          <th scope="col">Loan term</th>
          <th scope="col">Edit</th>
          <th scope="col">Delete</th>
        </tr>
      </thead>
      <#if loanoffers?? && (loanoffers?size > 0)>
      <#list loanoffers as loanoffer>
      <tbody>
        <tr>
          <th scope="row">${loanoffer?index + 1}</th>
          <td><a href="/loanoffers/${loanoffer.uuid}">Loan offer #${loanoffer?index + 1}</a></td>
          <td>${loanoffer.client.fullName}</td>
          <td>${loanoffer.loan.name}</td>
          <td>${(loanoffer.amount / 100)?string.currency}</td>
          <td>${loanoffer.loanTerm} months</td>
          <td> <a href="/loanoffers/${loanoffer.uuid}/edit">Edit</a></td>
          <td><a href="/loanoffers/${loanoffer.uuid}/delete">Delete</a></td>
        </tr>
      </tbody>
      </#list>
    </table>
    </#if>
</@main.page>