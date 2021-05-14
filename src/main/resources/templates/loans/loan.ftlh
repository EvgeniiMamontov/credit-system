<#import "/main.ftlh" as main>
<@main.page>
  <H3> Loan </H3>
    <table class="table table-primary container mt-5">
      <thead>
        <tr>
          <th scope="col">UUID</th>
          <th scope="col">Name</th>
          <th scope="col">Limit</th>
          <th scope="col">Interest rate</th>
          <th scope="col">Bank</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${loan.uuid}</td>
          <td>${loan.name}</td>
          <td>${(loan.limit / 100)?string.currency}</td>
          <td>${loan.interestRate * 100} %</td>
          <td>${loan.bank.name}</td>
        </tr>
      </tbody>
    </table>

  <H4> Loan offers: </H4>
    <table class="table table-secondary container mt-5">
      <thead>
        <tr>
          <th scope="col">Client</th>
          <th scope="col">Loan</th>
          <th scope="col">Amount</th>
          <th scope="col">Loan term</th>
          <th scope="col">First payment date</th>
        </tr>
      </thead>
    <#if loan.loanOffers?? && (loan.loanOffers?size > 0)>
    <#list loan.loanOffers as loanOffer>
      <tbody>
        <tr>
          <td>${loanOffer.client.fullName}</td>
          <td>${loanOffer.loan.name}</td>
          <td>${(loanOffer.amount / 100)?string.currency}</td>
          <td>${loanOffer.loanTerm} months</td>
          <td>${loanOffer.date}</td>
        </tr>
      </tbody>
    </#list>
    </#if>
    </table>
</@main.page>
