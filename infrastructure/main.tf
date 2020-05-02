provider "aws" {
    region = var.region
}

resource "aws_s3_bucket" "bucket" {
      bucket = "fedora-saver"
      acl    = "private"
      versioning {
        enabled = true
      }
      tags = {
        Name  = "Saver"
      }
}