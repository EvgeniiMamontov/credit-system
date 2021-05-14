<#import "/main.ftlh" as main>
<@main.page>
<form>
  <div class="form-group row">
    <div class="form-group">
      <h5> Really delete? </h5>
      <label for="name">Name</label>
      <input type="text" class="form-control" id="name" name="name" value="${loan.name}" readonly required>
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-auto">
      <button type="submit" formmethod="get" formaction="/loans" class="btn btn-success">Nope!</button>
    </div>
    <div class="col-sm-auto">
      <button type="submit" formmethod="post" formaction="/loans/${loan.uuid}/delete" class="btn btn-danger">Delete</button>
    </div>
  </div>
</form>
</@main.page>