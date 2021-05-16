<#import "/main.ftlh" as main>
<@main.page>
  <H3> Client </H3>
    <table class="table table-primary container mt-5">
      <thead>
        <tr>
          <th scope="col">UUID</th>
          <th scope="col">Name</th>
          <th scope="col">Phone number</th>
          <th scope="col">Email</th>
          <th scope="col">Passport number</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${client.uuid}</td>
          <td>${client.fullName}</td>
          <td>${client.phoneNumber}</td>
          <td>${client.email}</td>
          <td>${client.passportNumber}</td>
        </tr>
      </tbody>
    </table>
  <form method="get" action="/loanoffers/new">
    <button class="btn btn-primary" type="submit">Create loan offer</button>
  </form>
</@main.page>