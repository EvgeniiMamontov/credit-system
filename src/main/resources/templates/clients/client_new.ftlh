<#import "/main.ftlh" as main>
<@main.page>
<form method="post">
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="name">Full name</label>
      <input type="text" class="form-control" id="name" name="name" minlength="5" maxlength="100" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="phone">Phone number</label>
      <input type="text" class="form-control" id="phone" name="phone" title="Enter 5 to 15 digits" pattern="[0-9]{5,15}" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="email">Email</label>
      <input type="text" class="form-control" id="email" name="email" maxlength="50" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="passport">Passport number</label>
      <input type="text" class="form-control" id="passport" name="passport" minlength="5" maxlength="20" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <button type="submit" class="btn btn-primary">Create</button>
    </div>
  </div>
</form>
</@main.page>