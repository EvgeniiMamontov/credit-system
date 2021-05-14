<#import "/main.ftlh" as main>
<@main.page>
    <form action="/clients/new">
      <button class="btn btn-primary" type="submit">New client</button>
    </form>
    <table class="table container mt-5">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Phone number</th>
          <th scope="col">Email</th>
          <th scope="col">Passport number</th>
          <th scope="col">Edit</th>
          <th scope="col">Delete</th>
        </tr>
      </thead>
      <#if clients?? && (clients?size > 0)>
      <#list clients as client>
      <tbody>
        <tr>
          <th scope="row">${client?index + 1}</th>
          <td><a href="/clients/${client.uuid}">${client.fullName}</a></td>
          <td>${client.phoneNumber}</td>
          <td>${client.email}</td>
          <td>${client.passportNumber}</td>
          <td> <a href="/clients/${client.uuid}/edit">Edit</a></td>
          <td><a href="/clients/${client.uuid}/delete">Delete</a></td>
        </tr>
      </tbody>
      </#list>
    </table>
    </#if>
</@main.page>
