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
              <#if loanoffer.client.uuid == client.uuid> selected </#if>
            value="${client.uuid}">${client.fullName}</option>
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
      <input class="form-control" type="number" id="summ" name="summ"  min="1" max="${(loanoffer.loan.limit/ 100)?c}" value="${(loanoffer.amount / 100)?c}" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="loan_term">Loan term (months)</label><br>
      <input class="form-control" type="number" id="loan_term" name="loan_term"  min="1" max="240"  value="${loanoffer.loanTerm?c}" required>
    </div>
  </div>
  <div class="form-group row">
    <div class="form-group col-3">
      <label for="date">First payment date</label><br>
      <input class="form-control" type="date" id="date" name="date" min="${.now?string['yyyy-MM-dd']}" value="${loanoffer.date}" required>
    </div>
  </div>

  <div class="form-group row">
    <div class="form-group col-3">
      <button type="submit" class="btn btn-primary">Update</button>
    </div>
  </div>
  <script>
    function getLoanLimitValue() {
        var arr={<#list loans as loan>"${loan.uuid}":${loan.limit?c}, </#list>};
        var select = document.getElementById('loan_uuid');
        var value = select.value;
        document.getElementById('summ').max = arr[value] / 100;
    }
  </script>
</form>
</@main.page>