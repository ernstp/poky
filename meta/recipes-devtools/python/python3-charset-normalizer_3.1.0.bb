DESCRIPTION = "Truly universal encoding detector in pure Python"
HOMEPAGE = "https://charset-normalizer.readthedocs.io"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0974a390827087287db39928f7c524b5"

SRC_URI[sha256sum] = "34e0a2f9c370eb95597aae63bf85eb5e96826d81e3dcf88b8886012906f509b5"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
