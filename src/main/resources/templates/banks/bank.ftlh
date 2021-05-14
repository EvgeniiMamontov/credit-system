<#import "/main.ftlh" as main>
<@main.page>
  <H3> Bank </H3>
    <table class="table table-primary container mt-5">
      <thead>
        <tr>
          <th scope="col">UUID</th>
          <th scope="col">Name</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${bank.uuid}</td>
          <td>${bank.name}</td>
        </tr>
      </tbody>
    </table>

  <H4> Loans: </H4>
    <table class="table table-secondary container mt-5">
      <thead>
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Limit</th>
          <th scope="col">Interest rate %</th>
        </tr>
      </thead>
    <#if bank.loans?? && (bank.loans?size > 0)>
    <#list bank.loans as loan>
      <tbody>
        <tr>
          <td>${loan.name}</td>
          <td>${(loan.limit / 100)?string.currency}</td>
          <td>${(loan.interestRate * 100)?c} %</td>
        </tr>
      </tbody>
    </#list>
    </#if>
    </table>

  <H4> Clients: </H4>
    <table class="table table-secondary container mt-5">
      <thead>
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Phone</th>
          <th scope="col">Email</th>
          <th scope="col">Passport number</th>
        </tr>
      </thead>
    <#if bank.clients?? && (bank.clients?size > 0)>
    <#list bank.clients as client>
      <tbody>
        <tr>
          <td>${client.fullName}</td>
          <td>${client.phoneNumber}}</td>
          <td>${client.email}</td>
          <td>${client.passportNumber}</td>
        </tr>
      </tbody>
    </#list>
    </#if>
    </table>
</@main.page>
