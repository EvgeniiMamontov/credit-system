<#import "/main.ftlh" as main>
<@main.page>
  <H3> Loan offer </H3>
    <table class="table table-primary container mt-5">
      <thead>
        <tr>
          <th scope="col">UUID</th>
          <th scope="col">Client</th>
          <th scope="col">Loan</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${loanoffer.uuid}</td>
          <td>${loanoffer.client.fullName}</td>
          <td>${loanoffer.loan.name}</td>
        </tr>
      </tbody>
    </table>

  <H4> Loan offer details: </H4>
    <table class="table table-secondary container mt-5">
      <thead>
        <tr>
          <th scope="col">Amount</th>
          <th scope="col">Loan term</th>
          <th scope="col">Interest rate %</th>
          <th scope="col">Interest Amount TOTAL</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${(loanoffer.amount / 100)?string.currency}</td>
          <td>${loanoffer.loanTerm} months</td>
          <td>${(loanoffer.loan.interestRate * 100)?c} %</td>
          <td>${(loanoffer.interestTotal / 100)?string.currency}</td>
        </tr>
      </tbody>
    </table>

  <H4> Payment schedule: </H4>
    <table class="table table-info container mt-5">
      <thead>
        <tr>
          <th scope="col">Date</th>
          <th scope="col">Payment Amount</th>
          <th scope="col">Principal Amount</th>
          <th scope="col">Interest Amount</th>
        </tr>
      </thead>
    <#if loanoffer.paymentSchedule?? && (loanoffer.paymentSchedule?size > 0)>
    <#list loanoffer.paymentSchedule as payment>
      <tbody class="table-light">
        <tr>
          <td>${payment.date}</td>
          <td>${(payment.paymentAmount / 100)?string.currency}</td>
          <td>${(payment.principalAmount / 100)?string.currency}</td>
          <td>${(payment.interestAmount / 100)?string.currency}</td>
        </tr>
      </tbody>
    </#list>
    </#if>
    </table>
</@main.page>