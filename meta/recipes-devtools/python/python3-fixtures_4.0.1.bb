SUMMARY = " Python fixtures for testing / resource management"
HOMEPAGE = "https://github.com/testing-cabal/fixtures"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=239e2f4698b85aad5ed39bae5d2ef226"

inherit pypi setuptools3

SRC_URI[sha256sum] = "d2758826400d095b79666cf93a32a84f50ff8cd179831927efb48cd1e3ca7466"

DEPENDS += " \
    ${PYTHON_PN}-pbr-native \
    "

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-pbr \
    "

BBCLASSEXTEND = "nativesdk"
