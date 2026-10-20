from setuptools import setup, find_packages

setup(
    name='apiverve_palindromechecker',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Palindrome Checker tests whether a string reads the same forwards and backwards, with options to ignore casing, spacing, and punctuation. It returns the boolean verdict, the normalized text, the reversed comparison string, and the length of the longest palindromic sequence.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/palindromechecker?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
