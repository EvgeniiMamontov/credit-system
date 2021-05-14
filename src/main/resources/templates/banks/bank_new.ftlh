<#import "/main.ftlh" as main>
<@main.page>
<form method="post">
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="name">Name</label>
      <input type="text" class="form-control" id="name" name="name" minlength="3" maxlength="50" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <button type="submit" class="btn btn-primary">Create</button>
    </div>
  </div>
</form>
</@main.page>