<#import "/main.ftlh" as main>
<@main.page>
<form method="post">
  <div class="form-group row">
    <input type="hidden" id="uuid" name="uuid" required value="${loan.uuid}">
    <div class="form-group col-3">
      <label for="name">Name</label>
      <input type="text" class="form-control" id="name" name="name" minlength="5" maxlength="50" value="${loan.name}" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="limit">Limit $</label>
      <input type="number" class="form-control" id="limit" name="limit" title="Enter $1 to $9'999'999" min="1" max="999999999" value="${(loan.limit / 100)?c}" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="interest">Interest %</label>
      <input type="number" class="form-control" id="interest" name="interest" min="0" max="99.99" step="0.01" pattern="^\d+(?:\.\d{1,2})?$" value="${(loan.interestRate * 100)?string["0.##"]}" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="bank">Bank</label>
      <select class="form-control" id="bank" name="bank" required>
        <#if banks??>
          <#list banks as bank>
            <option
              <#if bank.uuid == loan.bank.uuid> selected </#if>
             value="${bank.uuid}">${bank.name}</option>
          </#list>
        </#if>
      </select>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <button type="submit" class="btn btn-primary">Update</button>
    </div>
  </div>
</form>
</@main.page>
