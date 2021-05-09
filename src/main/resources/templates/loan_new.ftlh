<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>New Loan</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
    <H3>New loan</H3>
      <br>
    <form method="post">
      <label for="name">Name:</label><br>
      <input type="text" id="name" name="name" required minlength="5" maxlength="50"><br>
      <label for="limit">Limit:</label><br>
      <input type="text" id="limit" name="limit" required maxlength="20"><br>
      <label for="interest">Interest:</label><br>
      <input type="text" id="interest" name="interest" required maxlength="2"><br>
      <input type="submit" value="Create">
    </form>
  </body>
</html>