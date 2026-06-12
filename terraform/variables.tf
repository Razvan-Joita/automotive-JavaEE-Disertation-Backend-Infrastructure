variable "resource_group_name" {
  type    = string
  default = "rg-automotive-javaee"
}

variable "location" {
  type    = string
  default = "spaincentral"
}

variable "mysql_location" {
  type    = string
  default = "spaincentral"
}

variable "mysql_server_name" {
  type    = string
  default = "automotive-javaee-mysql-rz01"
}

variable "mysql_database_name" {
  type    = string
  default = "automotiveJavaEE"
}

variable "mysql_admin_username" {
  type      = string
  sensitive = true
}

variable "mysql_admin_password" {
  type      = string
  sensitive = true
}

variable "app_service_plan_name" {
  type    = string
  default = "asp-automotive-javaee"
}

variable "app_name" {
  type    = string
  default = "automotive-javaee-rz01"
}

variable "dockerhub_username" {
  type      = string
  sensitive = true
}

variable "dockerhub_token" {
  type      = string
  sensitive = true
}

variable "docker_image_name" {
  type    = string
  default = "automotive-javaee-app"
}

variable "docker_image_tag" {
  type    = string
  default = "latest"
}