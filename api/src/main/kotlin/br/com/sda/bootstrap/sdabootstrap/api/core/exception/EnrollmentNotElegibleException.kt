package br.com.sda.bootstrap.sdabootstrap.api.core.exception

class EnrollmentNotElegibleException: BusinessException {
    companion object {
        private const val MESSAGE = "Enrollment not elegible for required course."
    }
    constructor() : super(MESSAGE)
    constructor(cause: Throwable?) : super(MESSAGE, cause)
}
