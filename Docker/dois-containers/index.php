<?php
$host = 'db';
$dbname = 'mydb';
$username = 'user';
$password = 'password';

try {
    $pdo = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
    echo "Conexão com MySQL bem-sucedida!";
    
    // Teste simples
    $result = $pdo->query("SELECT VERSION() as version");
    $row = $result->fetch();
    echo "<br>Versão do MySQL: " . $row['version'];
    
} catch (PDOException $e) {
    echo "Erro: " . $e->getMessage();
}
?>