<#import "/main.ftlh" as main>
<@main.page>
    <form action="/loans/new">
      <button class="btn btn-primary" type="submit">New loan</button>
    </form>
    <table class="table container mt-5">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Limit</th>
          <th scope="col">Interest</th>
          <th scope="col">Bank</th>
          <th scope="col">Edit</th>
          <th scope="col">Delete</th>
        </tr>
      </thead>
      <#if loans?? && (loans?size > 0)>
      <#list loans as loan>
      <tbody>
        <tr>
          <th scope="row">${loan?index + 1}</th>
          <td><a href="/loans/${loan.uuid}">${loan.name}</a></td>
          <td>${(loan.limit / 100)?string.currency}</td>
          <td>${loan.interestRate * 100} %</td>
          <td>${loan.bank.name}</td>
          <td><a href="/loans/${loan.uuid}/edit">Edit</a></td>
          <td><a href="/loans/${loan.uuid}/delete">Delete</a></td>
        </tr>
      </tbody>
      </#list>
    </table>
    </#if>
</@main.page>