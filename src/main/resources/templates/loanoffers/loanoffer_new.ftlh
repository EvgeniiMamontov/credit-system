<#import "/main.ftlh" as main>
<@main.page>
<form method="post">
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="client_uuid">Client</label>
      <select class="form-control" name="client_uuid" id="client_uuid" required>
        <#if clients??>
          <#list clients as client>
            <option value="${client.uuid}">${client.fullName}</option>
          </#list>
        </#if>
      </select>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="loans">Loan</label>
      <select class="form-control" name="loan_uuid" id="loan_uuid" onchange="getLoanLimitValue();" required>
        <#if loans??>
          <#list loans as loan>
            <option value="${loan.uuid}">${loan.name}</option>
          </#list>
        </#if>
      </select>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="summ">Loan amount $</label><br>
      <input class="form-control" type="number" id="summ" name="summ" min="1" max="999999999" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="loan_term">Loan term (months)</label><br>
      <input class="form-control" type="number" id="loan_term" name="loan_term" min="1" max="240" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="date">First payment date</label><br>
      <input class="form-control" type="date" id="date" name="date" min="${.now?string['yyyy-MM-dd']}" required>
    </div>
  </div>

  <div class="form-group row">
    <div class="form-group col-3">
      <button type="submit" class="btn btn-primary">Create</button>
    </div>
  </div>
</form>
<script>
  function getLoanLimitValue() {
      var arr={<#list loans as loan>"${loan.uuid}":${loan.limit?c}, </#list>};
      var select = document.getElementById('loan_uuid');
      var value = select.value;
      document.getElementById('summ').max = arr[value] / 100;
  }
</script>
</@main.page>