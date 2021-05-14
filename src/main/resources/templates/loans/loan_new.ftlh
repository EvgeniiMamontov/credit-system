<#import "/main.ftlh" as main>
<@main.page>
<form method="post">
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="name">Name</label>
      <input type="text" class="form-control" id="name" name="name" minlength="5" maxlength="50" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="limit">Limit $</label>
      <input type="text" class="form-control" id="limit" name="limit" title="Enter $1 to $9'999'999" min="0" max="9999999" min="0" max="999999999" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="interest">Interest %</label>
      <input type="text" class="form-control" id="interest" name="interest" min="0" step="0.01" title="Currency" pattern="^\d+(?:\.\d{1,2})?$" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="bank">Bank</label>
      <select class="form-control" id="bank" name="bank" required>
        <#if banks??>
          <#list banks as bank>
            <option value="${bank.uuid}">${bank.name}</option>
          </#list>
        </#if>
      </select>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <button type="submit" class="btn btn-primary">Create</button>
    </div>
  </div>
</form>
</@main.page>