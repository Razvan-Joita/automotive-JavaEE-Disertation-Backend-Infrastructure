output "javaee_customers_url" {
  value = "https://${azurerm_linux_web_app.javaee_app.default_hostname}/ROOT/api/v1/customers"
}

output "javaee_appointments_url" {
  value = "https://${azurerm_linux_web_app.javaee_app.default_hostname}/ROOT/api/v1/appointments"
}

output "javaee_k6_base_url" {
  value = "https://${azurerm_linux_web_app.javaee_app.default_hostname}/ROOT/api"
}

output "mysql_host" {
  value = azurerm_mysql_flexible_server.mysql.fqdn
}

output "jdbc_url" {
  value     = "jdbc:mysql://${azurerm_mysql_flexible_server.mysql.fqdn}:3306/${var.mysql_database_name}?useSSL=true&requireSSL=true&serverTimezone=UTC"
  sensitive = true
}