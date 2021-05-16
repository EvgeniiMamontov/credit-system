<#import "/main.ftlh" as main>
<@main.page>
  <div class="form-group col-2">
    <form action="/loanoffers/new">
      <button class="btn btn-primary" type="submit">Apply for a loan</button>
    </form>
  </div>
  <div class="form-group col-2">
    <form action="/clients/new">
      <button class="btn btn-secondary" type="submit">Create client</button>
    </form>
  </div>
  <div class="form-group col-2">
    <form action="/loans/new">
      <button class="btn btn-secondary" type="submit">Create loan</button>
    </form>
  </div>
  <div class="form-group col-2">
    <form action="/banks/new">
      <button class="btn btn-secondary" type="submit">Create bank</button>
  </form>
  </div>
</@main.page>