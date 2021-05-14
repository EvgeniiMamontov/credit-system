<#import "/main.ftlh" as main>
<@main.page>
<form method="post">
  <input type="hidden" id="loanoffer_uuid" name="loanoffer_uuid" value="${loanoffer.uuid}" required>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="client_uuid">Client</label>
      <select class="form-control" name="client_uuid" id="client_uuid" required>
        <#if clients??>
          <#list clients as client>
            <option
              <#if currentClient.uuid == client.uuid> selected </#if>
            value="${client.uuid}">${client.fullName}</option>
          </#list>
        </#if>
      </select>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="loans">Loan</label>
      <select class="form-control" name="loan_uuid" id="loan_uuid" required>
        <#if loans??>
          <#list loans as loan>
            <option
              <#if loanoffer.loan.uuid == loan.uuid> selected </#if>
            value="${loan.uuid}">${loan.name}</option>
          </#list>
        </#if>
      </select>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="summ">Loan amount $</label><br>
      <input class="form-control" type="text" id="summ" name="summ" pattern="[0-9]{1,20}" value="${(loanoffer.amount / 100)?c}" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="loan_term">Loan term (months)</label><br>
      <input class="form-control" type="text" id="loan_term" name="loan_term" pattern="[0-9]{1,3}" min="1" max="240" value="${loanoffer.loanTerm?c}" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="date">First payment date</label><br>
      <input class="form-control" type="date" id="date" name="date" value="${loanoffer.date}" required>
    </div>
  </div>

  <div class="form-group row">
    <div class="form-group col-3">
      <button type="submit" class="btn btn-primary">Update</button>
    </div>
  </div>
</form>
</@main.page>