SUMMARY = "Snake image for cm4 io board"
HOMEPAGE = "gis1501@gmail.com"
LICENSE = "MIT"

include recipes-core/images/core-image-minimal.bb

IMAGE_FEATURES += "package-management splash"
IMAGE_LINGUAS = "en-us ru-ru"

MODULES_FILES = " \
    modules-files \
    script-files \
"

CORE_OS = " \
    openssh \
    openssh-keygen \
    openssh-sftp-server \
    tzdata \
"

NET_TOOLS_INSTALL = " \
    ethtool \
"

FS_TOOLS_INSTALL = " \
    e2fsprogs-resize2fs \
"

TOOLS_INSTALL = " \
    devmem2 \
    dosfstools \
    util-linux \
"

IMAGE_INSTALL += " \
    kernel-modules \
    ${CORE_OS} \
    ${TOOLS_INSTALL} \
    ${NET_TOOLS_INSTALL} \
    ${FS_TOOLS_INSTALL} \
    ${MODULES_FILES} \
"

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    disable_bootlogd ; \
 "

export IMAGE_BASENAME = "mini-image"
