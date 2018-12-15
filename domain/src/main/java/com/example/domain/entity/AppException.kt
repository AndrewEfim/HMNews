package com.example.domain.entity

class AppException(val errorType:AppErrorType): Exception(),DomainEntity {
}