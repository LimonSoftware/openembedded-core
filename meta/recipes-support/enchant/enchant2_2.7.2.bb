SUMMARY = "Enchant Spell checker API Library"
DESCRIPTION = "A library (and command-line program) that wraps a number of \
different spelling libraries and programs with a consistent interface."
SECTION = "libs"
HOMEPAGE = "https://abiword.github.io/enchant/"
BUGTRACKER = "https://github.com/AbiWord/enchant/issues/"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "glib-2.0 groff-native"

inherit autotools pkgconfig github-releases

SRC_URI = "${GITHUB_BASE_URI}/download/v${PV}/enchant-${PV}.tar.gz"
SRC_URI[sha256sum] = "7cc3400a6657974a740b6e3c2568e2935c70e5302f07fadb2095366b75ecad6f"

GITHUB_BASE_URI = "https://github.com/AbiWord/enchant/releases"

S = "${WORKDIR}/enchant-${PV}"

PACKAGECONFIG ??= "aspell"
PACKAGECONFIG[aspell]  = "--with-aspell,--without-aspell,aspell,aspell"
PACKAGECONFIG[hunspell]  = "--with-hunspell,--without-hunspell,hunspell,hunspell"

FILES:${PN} += " \
    ${datadir}/enchant-2 \
    ${libdir}/enchant-2 \
"
FILES:${PN}-staticdev += "${libdir}/enchant-2/*.a"
