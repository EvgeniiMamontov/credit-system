<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Edit Bank</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
  <H3><a href="/">Edit Bank</a></H3>
    <br>
    <form method="put">
      <label for="name">ID:</label><br>
      <input type="text" id="uuid" name="uuid" required disabled value="${bank.uuid}"><br>
      <label for="name">Name:</label><br>
      <input type="text" id="name" name="name" required minlength="3" maxlength="50" value="${bank.name}"><br>
      <label for="limit">Limit:</label><br>
      <input type="submit" value="Update">
    </form>
  </body>
</html>
