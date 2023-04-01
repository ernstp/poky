DESCRIPTION = "Python HTTP for Humans."
HOMEPAGE = "https://requests.readthedocs.io"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

SRC_URI[sha256sum] = "98b1b2782e3c6c4904938b84c0eb932721069dfdb9134313beff7c83c2df24bf"

inherit pypi setuptools3

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-certifi \
    ${PYTHON_PN}-charset-normalizer \
    ${PYTHON_PN}-pysocks \
    ${PYTHON_PN}-urllib3 \
    ${PYTHON_PN}-chardet \
    ${PYTHON_PN}-idna \
"

CVE_PRODUCT = "requests"

BBCLASSEXTEND = "native nativesdk"
