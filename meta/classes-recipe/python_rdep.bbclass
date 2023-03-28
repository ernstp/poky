python do_python_rdep() {
    import pkg_resources as pkg

    sitepath = d.getVar('D', True) + d.getVar('PYTHON_SITEPACKAGES_DIR', True)
    python_pn = d.getVar('PYTHON_PN', True)
    pn = d.getVar('PN', True)

    dists = list(pkg.find_distributions(sitepath, only=True))
    if not dists:
        bb.fatal("QA: Could not parse requirements information from %s using setuptools" % (sitepath))
        return

    requirements = []
    for dist in dists:
        for req in dist.requires():
            requirements.append(python_pn + '-' + req.key)

    existing_rdeps = (d.getVar('RDEPENDS:%s' % pn, True) or "").split()
    missing = set(requirements).difference(set(existing_rdeps))
    if missing:
        bb.fatal("QA: rdepends on %s but they are not set as dependencies." % (' '.join(missing)))
}

python () {
    skip_rdep = d.getVar('SKIP_PYTHON_RDEP', True)
    if skip_rdep and skip_rdep == "1":
        d.setVarFlag('do_python_rdep', 'noexec', '1')
    else:
        d.appendVar('DEPENDS', ' python3-setuptools-native')
        d.appendVarFlag('do_python_rdep', 'depends', 'python3-setuptools-native:do_populate_sysroot')
}

do_python_rdep[vardeps] = "RDEPENDS:${PN}"
addtask do_python_rdep after do_install before do_package
