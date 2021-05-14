<#import "/main.ftlh" as main>
<@main.page>
    <form action="/banks/new">
      <button class="btn btn-primary" type="submit">New bank</button>
    </form>
    <table class="table container mt-5">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col">Edit</th>
          <th scope="col">Delete</th>
        </tr>
      </thead>
      <#if banks?? && (banks?size > 0)>
      <#list banks as bank>
      <tbody>
        <tr>
          <th scope="row">${bank?index + 1}</th>
          <td><a href="/banks/${bank.uuid}">${bank.name}</a></td>
          <td><a href="/banks/${bank.uuid}/edit">Edit</a></td>
          <td><a href="/banks/${bank.uuid}/delete">Delete</a></td>
        </tr>
      </tbody>
      </#list>
    </table>
    </#if>
</@main.page>